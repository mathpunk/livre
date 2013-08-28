require 'mongo'
require 'mongo_mapper'
require_relative '../config/config.rb'
require 'yaml'
require 'to_regexp'

class Texton 

  include MongoMapper::Document
  connection Mongo::Connection.new(Configuration::HOST)
  set_database_name Configuration::DATABASE

  # key :text_id, ObjectID
  key :body, String, :required => true
  key :name, String

  timestamps!             # Are both these lines necessary?
  key :date, Time         
  # many :subtextons      # Neat that you can do 'many' but not sure this
                          # belongs in our schema. 
  # key :tags, Array      # I'm guessing we'll want tags/keywords saved for
                          # search purposes. 

  def initialize(string, name="")
    @body = string
    @name = name
  end

  # Sigil methods
  @@sigils = YAML.load(open(File.join(File.expand_path(File.dirname(__FILE__)), '../grimoire/sigils')))
  @@sigils.each_entry do |name, description|
    pattern = description['pattern'].to_regexp
    style = description['style']
    if style == 'scan'
      define_method(name.to_sym) do 
        textons = []
        @body.scan(pattern) {|items| textons += items}
        textons
      end
    elsif style == 'split'
      define_method(name.to_sym) do 
        @body.split(pattern).map {|x| x.strip}
      end
    elsif style == 'chain'
      define_method(name.to_sym) do 
        results = []
        @body.lines {|line| results << line.split(pattern).each {|match| match.strip!}}
        results
      end
    else
      raise "Unknown style #{style} for sigil #{name}"
    end
  end

  # Missing methods are sent to @body; presumably they are String or singleton
  # messages. 
  def method_missing(message, *args)
    if @body.respond_to?(message)
      return @body.send(message, *args) 
    else
      raise "Method #{message} missing in both #{self.inspect} and #{@body.inspect}"
    end
  end

end
