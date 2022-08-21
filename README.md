### Hexlet tests and linter status:
[![Actions Status](https://github.com/vviace/java-project-lvl2/workflows/hexlet-check/badge.svg)](https://github.com/vviace/java-project-lvl2/actions)
### Codeclimate
[![Maintainability](https://api.codeclimate.com/v1/badges/308e03573bcb9f122df7/maintainability)](https://codeclimate.com/github/vviace/java-project-lvl2/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/308e03573bcb9f122df7/test_coverage)](https://codeclimate.com/github/vviace/java-project-lvl2/test_coverage)
### Cli-util compare two configuration files. 
#### Accept two arguments via the command line - the paths to these files. (configuration files locate at /src/test/resources)
#### There are result of comparing two different configuration files can be displayed in different formats (stylish, plain, json). 
## Install
> $ make install
## Build
> $ make build
## Run
> $ make run
## Build-install (with update dependency)
> $ make build-install
## Clean
> $ make clean
## Run project flag "-h"
> $ make run-app


## Compare two configuration .json files, flag "-f": default, stylish, plain.
> $ make diff-json, make diff-json-stylish, make diff-json-plain
[![asciicast](https://asciinema.org/a/1MIcyeapKJAwVOC7qu8hUQB6Q.svg)](https://asciinema.org/a/1MIcyeapKJAwVOC7qu8hUQB6Q)
## Compare two configuration .yml files, flag "-f": default, stylish, plain.
> $ make diff-yml, make diff-yml-stylish, make diff-yml-plain
[![asciicast](https://asciinema.org/a/2aC59QtTv1qW2MoM3M9viRbTt.svg)](https://asciinema.org/a/2aC59QtTv1qW2MoM3M9viRbTt)
### Compare two configuration .json or .yml files and output format is json.
> $ make diff-json-out, make diff-yml-json
[![asciicast](https://asciinema.org/a/m83QH7Hcw2KhlFjJLVHm3pFke.svg)](https://asciinema.org/a/m83QH7Hcw2KhlFjJLVHm3pFke)