#!/usr/bin/env ruby 

command = ARGV[0] || 'dot'
file = ARGV[1] || 'antioutline1.gv'
image_type = 'jpg'

`#{command} -T#{image_type} #{file} > #{file}.#{command}.#{image_type}`
