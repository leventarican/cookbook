Carbon language

* https://github.com/carbon-language/carbon-lang
* Announcement: https://youtu.be/omrY53kbVoA
* Contribution tools: https://github.com/carbon-language/carbon-lang/blob/trunk/docs/project/contribution_tools.md
* Why not Rust: https://github.com/carbon-language/carbon-lang/blob/trunk/docs/project/faq.md

################################################################################

Run code with interpreter carbon explorer
* Language: https://github.com/carbon-language/carbon-lang/tree/trunk/docs/design

```bash
# change to carbon-lang repository.
cd carbon-lang
bazel run //explorer -- ~/development/cookbook/carbon/a.carbon
```

################################################################################

# Check tool-chain installation

Clone repo
```bash
git clone https://github.com/carbon-language/carbon-lang
$ cd carbon-lang
```

```
# Build and run the explorer.
bazel run //explorer -- ./explorer/testdata/print/format_only.carbon
```

################################################################################

# Tool-chain installation.

## Brew
Install Homebrew. It's a package manager for macos and linux.
To get the latest version of brew packages, it will be necessary to periodically run brew upgrade.
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"
```

The installation took a while; it might stuck also.
After install you need to add brew in your `PATH`.
```
==> Next steps:
- Run these two commands in your terminal to add Homebrew to your PATH:
    echo 'eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"' >> /home/code/.profile
    eval "$(/home/linuxbrew/.linuxbrew/bin/brew shellenv)"
- Install Homebrew's dependencies if you have sudo access:
    sudo apt-get install build-essential
  For more information, see:
    https://docs.brew.sh/Homebrew-on-Linux
- We recommend that you install GCC:
    brew install gcc
- Run brew help to get started
- Further documentation:
    https://docs.brew.sh
```

Uninstall
```bash
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/uninstall.sh)"
```

Installed folder
```bash
ls /home/linuxbrew/.linuxbrew/
bin  Caskroom  Cellar  etc  Frameworks  Homebrew  include  lib  opt  sbin  share  var
```

## Python
Carbon requires Python 3.9 or newer.

## Bazel
Bazel is Carbon's standard build system. Bazelisk is recommended for installing Bazel.

After brew is installed now install bazelisk.

```bash
brew install bazelisk
```

## Clang and LLVM
Clang and LLVM are used to compile and link Carbon as part of its build.

After brew and bazelisk are installed now install llvm.

```bash
brew install llvm
```
