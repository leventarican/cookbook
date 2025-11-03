* REBOL programming language

> We rebel against the idea that modern software must be _large and complex_. In fact, we believe such systems lead to greater potential for failure, with disastrous social and economic consequences.

install and start rebol-view
```bash
# get rebol-view (there is also rebel-core but we start with GUI version)
https://www.rebol.com/downloads/v278/rebol-view-278-4-3.tar.gz

# install 32 bit's lib on 64 bit linux
sudo apt install libxt6:i386 libx11-6:i386
sudo apt install libxaw7:i386

# start
~/Downloads/releases/rebol-view$ ./rebol

# dotfolder
vim ~/.rebol/view/
desktop/      dojo/         edit-prefs.r  local/        public/
```

troubleshooting
* print dependencies with `ldd`
```bash
ldd ./rebol
        linux-gate.so.1 (0xf7ee5000)
        libX11.so.6 => /lib/i386-linux-gnu/libX11.so.6 (0xf7d76000)
        libXext.so.6 => /lib/i386-linux-gnu/libXext.so.6 (0xf7d60000)
        libXt.so.6 => not found
        libXaw.so.7 => not found
        libXmu.so.6 => not found
```
```

links
* https://www.rebol.com/view-platforms.html
* https://github.com/iarwain/adventofcode/tree/master
* https://www.rebol.com/why-rebol.html
