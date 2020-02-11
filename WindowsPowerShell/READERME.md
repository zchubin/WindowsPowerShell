# Powershell---[oh-my-posh](https://github.com/JanDeDobbeleer/oh-my-posh)

## Font
1. [sarasa更纱黑体](https://github.com/be5invis/Sarasa-Gothic/releases)
2. [powerline字体](https://github.com/powerline/fonts)
3. [nerd-fonts](https://github.com/ryanoasis/nerd-fonts)

## Prerequisites
```shell
choco install ConEmu

# C:\Users\<name>\AppData\Local\Temp\chocolatey\ConEmu\19.xx.xx.x\ConEmuSetup.19xxxx.exe
# C:\ProgramData\chocolatey\lib\ConEmu\tools\chocolateyInstall.ps1
```
### If you no **choco**,you can read **next steps**.
==== Non-Administrative Installation.
* Save the script below as **ChocolateyInstallNonAdmin.ps1.**
* Use the script below, determine where you might want Chocolatey installed if it is not to **C:\ProgramData\chocoportable**.
* Open PowerShell.exe.
* Run the following `Set-ExecutionPolicy Bypass -Scope Process -Force;`.
* Run `.\ChocolateyInstallNonAdmin.ps1`.
    
==== ChocolateyInstallNonAdmin.ps1:
```ps1
# Set directory for installation - Chocolatey does not lock
# down the directory if not the default
$InstallDir='C:\ProgramData\chocoportable'
$env:ChocolateyInstall="$InstallDir"

# If your PowerShell Execution policy is restrictive, you may
# not be able to get around that. Try setting your session to
# Bypass.
Set-ExecutionPolicy Bypass -Scope Process -Force;

# All install options - offline, proxy, etc at
# https://chocolatey.org/install
iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))
```
==== Examples of packages you can install:
```shell
choco install puppet-agent.portable -y
choco install ruby.portable -y
choco install git.commandline -y

# pick an editor
#choco install visualstudiocode.portable -y # not yet available
choco install notepadplusplus.commandline -y
#choco install nano -y
#choco install vim-tux.portable

# What else can I install without admin rights?
# https://chocolatey.org/packages?q=id%3Aportable
```
## Installation
You need to use the PowerShell Gallery to install oh-my-posh.

Install posh-git and oh-my-posh:
```shell
Install-Module posh-git -Scope CurrentUser
# C:\Users\<name>\AppData\Local\PackageManagement

Install-Module oh-my-posh -Scope CurrentUser
# C:\Users\<name>\OneDrive\<Documentation>\WindowsPowerShell
```
Enable the prompt:
```shell
# Start the default settings
Set-Prompt
# Alternatively set the desired theme:
Set-Theme Agnoster
```
In case you're running this on PS Core, make sure to also install version 2.0.0-beta1 of `PSReadLine`
```shell
Install-Module -Name PSReadLine -AllowPrerelease -Scope CurrentUser -Force -SkipPublisherCheck
```
To enable the engine edit your PowerShell profile:
```shell
if (!(Test-Path -Path $PROFILE )) { New-Item -Type File -Path $PROFILE -Force }
notepad $PROFILE
```
Append the following lines to your PowerShell profile:
```shell
Import-Module posh-git
Import-Module oh-my-posh
Set-Theme Paradox
```

## Configuration
List the current configuration:
```shell
$ThemeSettings
```
## Theme
You can tweak the settings by manipulating `$ThemeSettings`. This example allows you to tweak the branch symbol using a unicode character:
* 您可以通过操作$ ThemeSettings来调整设置。 此示例使您可以使用Unicode字符来调整分支符号：
```shell
$ThemeSettings.GitSymbols.BranchSymbol = [char]::ConvertFromUtf32(0xE0A0)
```
Also do not forget the Posh-Git settings itself (enable the stash indication for example):
* 同样不要忘记Posh-Git设置本身（例如启用隐藏指示）：
```shell
$GitPromptSettings
```
Hide your `username@domain` when not in a virtual machine for the Agnoster, Fish, Honukai, Paradox and Sorin themes:
* 当不在虚拟机中隐藏Agnoster，Fish，Honukai，Paradox和Sorin主题时，隐藏您的username @ domain：
```shell
$DefaultUser = 'yourUsernameHere'
```

**[More Theme](https://github.com/JanDeDobbeleer/oh-my-posh)**
---

 
#### Set-Theme Paradox
```shell
Set-Theme Agnoster 
Set-Culture en-US
```
## My opinion
* `oh-my-posh`It is a relatively complete `PowerShell` theme configuration engine, so we can also magically change a theme to make it achieve the effect we want, or even write a theme configuration by ourselves.
* Create a` `myTheme.psm1` under the theme folder** C: \ Users <user name> \ Documents \ WindowsPowerShell \ Modules \ oh-my-posh <version number> \ Themes **of `oh-my-posh` Modify it. Use` `Set-Theme myTheme` to make your custom theme take effect.

- `oh-my-posh`是相对比较完善的`PowerShell`主题配置引擎，因此我们也可以魔改某个主题，来让它达到我们想要的效果，甚至自己写一个主题配置也可以。
- 在`oh-my-posh`的主题文件夹**C:\Users\<用户名>\Documents\WindowsPowerShell\Modules\oh-my-posh\<版本号>\Themes**下新建一个`myTheme.psm1`,之后按照其他主题的写法进行修改就可以了。使用`Set-Theme myTheme`这个命令来让你的自定义主题生效。
 
**Note**：Some characters not supported by `Powerline fonts` are needed *[nerd-fonts](https://github.com/ryanoasis/nerd-fonts)*.