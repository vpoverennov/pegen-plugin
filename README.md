![JetBrains IntelliJ plugin](https://img.shields.io/jetbrains/plugin/v/13832-pegen?color=informational)
![JetBrains IntelliJ downloads](https://img.shields.io/jetbrains/plugin/d/13832-pegen?color=informational)
![GitHub](https://img.shields.io/github/license/vpoverennov/pegen-plugin?color=brightgreen)

IntelliJ plugin for PEG grammar using Guido's pegen syntax (https://github.com/gvanrossum/pegen)

You only get syntax highlighting for strings and rule names, error highlighting for unresolved 
rule names and go to definition/find usages on rules. Plugin breaks horribly on syntax errors,
has almost no other refactoring support. But it's better than editing black on white text.
I am not good at java or at writing intellij plugins, I made it for myself, but maybe you 
will also find it useful.

This plugin on JetBrains plugin website: https://plugins.jetbrains.com/plugin/13832-pegen

Screenshots:

![Screenshot 1](screenshots/syntax_hl.png)
![Screenshot 2](screenshots/unresolved_rule.png)
![Screenshot 3](screenshots/rename.png)

# how to build

- install gradle plugin for the IDE
- run `gradle package plugin` task from the side explorer
