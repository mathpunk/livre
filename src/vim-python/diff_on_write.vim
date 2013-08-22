au BufWritePre *.wiki call WriteDiff()
function! WriteDiff()
    python << endpython
import os
import vim
import json
import time
import tempfile
import subprocess
tf = tempfile.NamedTemporaryFile(delete=False)
tf.writelines(vim.current.buffer)
tf.flush()
bufname = vim.current.buffer.name
p = subprocess.Popen(['diff', '-n', tf.name, bufname], stdout=subprocess.PIPE)
o, e = p.communicate()

result = {
    'name': bufname,
    'diff': o,
    'when': time.time()
}
file(tf.name, 'w').write(json.dumps(result))
vim.command('echo "diff written to {}"'.format(tf.name))
endpython
endfunction
