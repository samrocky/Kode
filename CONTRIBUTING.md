# Kar Center Git Guidelines and Specifications

- [How to configure git](#how-to-configure-git)
- [How to use a ssh key](#how-to-use-a-ssh-key)
    - [Checking for Existing SSH Keys](#checking-for-existing-ssh-keys)
        - [In Linux and Mac](#in-linux-and-mac)
        - [In Windows](#in-windows)
    - [Generating a new SSH key and adding it to the machine's SSH agent](#generating-a-new-ssh-key-and-adding-it-to-the-machines-ssh-agent)
        - [Generating a new SSH key](#generating-a-new-ssh-key)

            - [In Linux and Mac](#in-linux-and-mac-1)
            - [In Windows](#in-windows-1)
        - [Adding SSH key to the ssh-agent](#adding-ssh-key-to-the-ssh-agent)
            - [In Linux](#in-linux)
            - [In Mac](#in-mac)
            - [in Windows](#in-windows-2)
    - [Adding SSH Public Key to Github Server](#adding-ssh-public-key-to-github-server)
- [How to write a proper commit message](#how-to-write-a-proper-commit-message)
    - [The Seven Rules of a Proper Git Commit Message](#the-seven-rules-of-a-proper-git-commit-message)
    - [Semantic Commit Messages](#semantic-commit-d)
- [Versioning Policy ](#version-controlling)
- [Copyright and License Tags](#copyright-and-license-tags)
    - [In JetBrains IDE's](#in-jetbrains-ides)

## How to Configure Git
- Be sure to config both the user.name, user.email and defualt branch name in your local git config

  `$ git config --global user.name "example name"`

  `$ git config --global user.email "example@example.com"`

  `$ git config --global init.defaultBranch master`

    > NOTE: Please use your full and real name and not a nickname and also use the email connected to your GitHub account.
## How to Use a SSH key 
You can access and write data in repositories on Github.com using SSH **(Secure Shell Protocol)**.
When you connect via SSH, you authenticate using a private key file on your local machine and a public key on Github.com servers. For more information, see ["About SSH"](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/about-ssh)

- [Checking for existing SSH keys.](#checking-for-existing-ssh-keys)
- [Generating a new SSH key and adding it to the machine's SSH agent.](#generating-a-new-ssh-key-and-adding-it-to-the-machines-ssh-agent)
- [Adding SSH Public Key to Github Server](#adding-ssh-public-key-to-github-server)
### Checking for Existing SSH Keys
#### in Linux and Mac :
1. Open Terminal
2. Enter `ls -al ~/.ssh` to see if existing SSH keys are present.

        $ ls -al ~/.ssh\
        # Lists the files in your .ssh directory, if they exist

3. Check the directory listing to see if you already have a public SSH key. By default, the filename of a supported public key for GitHub AE is **id_rsa.pub**.

#### in Windows : 
1. Open Git Bash 
2. Enter `ls -al ~/.ssh` to see if existing SSH keys are present.

        $ ls -al ~/.ssh\
        # Lists the files in your .ssh directory, if they exist

3. Check the directory listing to see if you already have a public SSH key. By default, the filename of a supported public key for GitHub AE is **id_rsa.pub**.


> **NOTE:** If you already have an **id_rsa.pub** file proceed to [This Section](#adding-ssh-public-key-to-github-server)


### Generating a new SSH key and adding it to the machine's SSH agent

### Generating a new SSH key
You can generate a new SSH key on your local machine. After you generate the key, you can add the public key to your account on GitHub AE to enable authentication for Git operations over SSH.
#### In Linux and Mac : 
1. Open Terminal
2. Paste the text below, replacing the email used in the example with your GitHub AE email address.

    `$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"`

     This creates a new SSH key, using the provided email as a label.
    
    `> Generating public/private ALGORITHM key pair.`

    When you're prompted to "Enter a file in which to save the key", you can press Enter to accept the default file location. Please note that if you created SSH keys previously, ssh-keygen may ask you to rewrite another key, in which case we recommend creating a custom-named SSH key. To do so, type the default file location and replace id_ALGORITHM with your custom key name.

    `> Enter a file in which to save the key (/home/YOU/.ssh/id_ALGORITHM):[Press enter]`
3. At the prompt, type a secure passphrase.

    `> Enter passphrase (empty for no passphrase): [Type a passphrase]`

    `> Enter same passphrase again: [Type passphrase again]`

#### In Windows :
1. Open Git Bash
2. Paste the text below, replacing the email used in the example with your GitHub AE email address.

    `$ ssh-keygen -t rsa -b 4096 -C "your_email@example.com"`

     This creates a new SSH key, using the provided email as a label.
    
    `> Generating public/private ALGORITHM key pair.`

    When you're prompted to "Enter a file in which to save the key", you can press Enter to accept the default file location. Please note that if you created SSH keys previously, ssh-keygen may ask you to rewrite another key, in which case we recommend creating a custom-named SSH key. To do so, type the default file location and replace id_ALGORITHM with your custom key name.

    `> Enter a file in which to save the key (/home/YOU/.ssh/id_ALGORITHM):[Press enter]`
3. At the prompt, type a secure passphrase.

    `> Enter passphrase (empty for no passphrase): [Type a passphrase]`

    `> Enter same passphrase again: [Type passphrase again]`
### Adding SSH key to the ssh-agent
#### In Linux : 
1. Start the ssh-agent in the background.

    `$ eval "$(ssh-agent -s)"`

    `> Agent pid 59566`

    Depending on your environment, you may need to use a different command. For example, you may need to use root access by running `sudo -s -H` before starting the ssh-agent, or you may need to use `exec ssh-agent bash` or `exec ssh-agent zsh` to run the ssh-agent.

2. Add your SSH private key to the ssh-agent.

    If you created your key with a different name, or if you are adding an existing key that has a different name, replace id_rsa in the command with the name of your private key file.

    `ssh-add ~/.ssh/id_rsa`

3. Add the SSH public key to your account on GitHub.

#### In Mac :

1. Start the ssh-agent in the background.

    `$ eval "$(ssh-agent -s)"`

    `> Agent pid 59566`

    Depending on your environment, you may need to use a different command. For example, you may need to use root access by running `sudo -s -H` before starting the ssh-agent, or you may need to use `exec ssh-agent bash` or `exec ssh-agent zsh` to run the ssh-agent.

2. If you're using macOS Sierra 10.12.2 or later, you will need to modify your ~/.ssh/config file to automatically load keys into the ssh-agent and store passphrases in your keychain.
    - First, check to see if your `~/.ssh/config` file exists in the default location. 

        `$ open ~/.ssh/config`

        `> The file /Users/YOU/.ssh/config does not exist.`
    - If the file doesn't exist, create the file.

        `$ touch ~/.ssh/config`
    
    - Open your `~/.ssh/config` file, then modify the file to contain the following lines. If your SSH key file has a different name or path than the example code, modify the filename or path to match your current setup.

            Host HOSTNAME
              AddKeysToAgent yes
              UseKeychain yes
              dentityFile ~/.ssh/id_ecdsa

3. Add your SSH private key to the ssh-agent and store your passphrase in the keychain. If you created your key with a different name, or if you are adding an existing key that has a different name, replace id_rsa in the command with the name of your private key file.

    `ssh-add --apple-use-keychain ~/.ssh/id_rsa`

#### In Windows : 

1. In a new admin elevated PowerShell window, ensure the ssh-agent is running. You can use the "Auto-launching the ssh-agent" instructions in ["Working with SSH key passphrases"](https://docs.github.com/en/github-ae@latest/authentication/connecting-to-github-with-ssh/working-with-ssh-key-passphrases), or start it manually:

    `# start the ssh-agent in the background`

    `Get-Service -Name ssh-agent | Set-Service -StartupType Manual`

    `Start-Service ssh-agent`

2. In a terminal window without elevated permissions, add your SSH private key to the ssh-agent. If you created your key with a different name, or if you are adding an existing key that has a different name, replace *id_rsa* in the command with the name of your private key file.

    `ssh-add c:\Users\YOU\.ssh\id_ed25519`


### Adding SSH Public Key to Github Server

You can add an SSH key and use it for authentication, or commit signing, or both. If you want to use the same SSH key for both authentication and signing, you need to upload it twice.

After adding a new SSH authentication key to your account on GitHub.com, you can reconfigure any local repositories to use SSH. For more information, see ["Managing remote repositories."](https://docs.github.com/en/get-started/getting-started-with-git/managing-remote-repositories#switching-remote-urls-from-https-to-ssh)

1. Copy the SSH public key to your clipboard.

    If your SSH public key file has a different name than the example code, modify the filename to match your current setup. When copying your key, don't add any newlines or whitespace.

    `$ cat ~/.ssh/id_ed25519.pub`

    `# Then select and copy the contents of the id_ed25519.pub file`

2. In the upper-right corner of any page, click your profile photo, then click Settings.

    <img src="https://docs.github.com/assets/cb-45016/mw-1440/images/help/settings/userbar-account-settings-global-nav-update.webp" alt="image" width="50%" height="auto">

3. In the **"Access"** section of the sidebar, click  **SSH and GPG keys**.

4. Click **New SSH key** or **Add SSH key**.

5. In the "Title" field, add a descriptive label for the new key. For example, if you're using a personal laptop, you might call this key "Personal laptop".

6. Select the type of key, either authentication or signing. For more information about commit signing, see ["About commit signature verification."](https://docs.github.com/en/authentication/managing-commit-signature-verification/about-commit-signature-verification)

7. In the "Key" field, paste your public key.

8. Click **Add SSH key**.

9. If prompted, confirm access to your account on GitHub. For more information, see ["Sudo mode"](https://docs.github.com/en/authentication/keeping-your-account-and-data-secure/sudo-mode)

## How to Write a Proper Commit Message

<p align="center"><img src="https://cbea.ms/content/images/size/w2000/2021/01/git_commit_2x.png" alt="a meme " width="80%" height="auto"></p>

### The Seven Rules of a Proper Git Commit Message
1. Separate subject from body with a blank line
2. Limit the subject line to 50 characters
3. Capitalize the subject line
4. Do not end the subject line with a period
5. Use the imperative mood and simple present tense in the subject line
6. Wrap the body at 72 characters
7. Use the body to explain what and why vs. how

**You can also read the official document from "5.2 Distributed Git - Contributing to a Project", [Here](https://www.git-scm.com/book/en/v2/Distributed-Git-Contributing-to-a-Project#_commit_guidelines)**

### Semantic Commit Messages
Always use one of the following commit tags at the beginning of your commmit.

1. #### [init]

    When starting a new project as the first commit.

    #### Example :

        [init] Initialize ABACService

2. #### [feature]

    A new feature (also small additions). Most likely it will be an added feature, but it could also be removed. This can only happen in "master" branch or when ceating a new branch, because no new features are allowed in older branches. Exceptions to this  ve to be discussed on a case-to-case basis with the corresponding release managers.

    #### Example :

        [feature] Initialize Login dashboard

2. #### [implementation]

    When adding new sections to a Feature.

    #### Example :
        [implementation] Add Accessdicision 
3. ####  [improvement]

    When improving sections of a Feature.

    #### Example :
        [improvement] Improve FileEntity hashcode
5. #### [bugfix]

    A fix for a bug.

    #### Example :
        [bugfix] Remove starter code - Fix liquibase
6. #### [refactor]

    Refactoring production code, eg. renaming a variable

    #### Example :
        [refactor] Rename memberId to userId
7. #### [test]
    #### Example :
        [test] Test UserService regesterUser

## Version Controlling

As we have not established a versioning policy yet, we will discuss all proposed versions in a public session. You are required to consult with your seniors or release managers prior to making any changes to the versions.


## Copyright and License Tags

### In JetBrains IDE's:
1. Press `Ctrl` `Alt` `S` to open the IDE settings and then select **Editor | Copyright | Copyright Profiles**.

2. To configure the default profile for all newly created projects, select **File | New Projects Setup | Settings for New Projects**.

3. Click **+** and "Kar.center" name the new profile.

4. Enter the copyright notice text.

        Copyright (c) $originalComment.match("Copyright \(c\) (\d+)", 1, "-", "$today.year")$today.year. 
        All rights reserved. 
        This code is the property of 'Kar.center' and may not be reproduced or distributed without permission. 
        Author: Example Name 
        Contact: example@example.com
- After 

        /*
        * Copyright (c) 2024. 
        * All rights reserved. 
        * This code is the property of 'Kar.center' and  may not be reproduced or distributed without permission. 
        * Author: Sam Rocky 
        * Contact: samrocky404@gmail.com
        */
5. Once the profile is configured, you can select the scope of files to which you want to add the text or set this profile as the default profile for all files in the project that are not included to any scope.

#### Assign a profile to a scope of files
Select the scope of files to which you want to add the configured copyright text:
1. Press `Ctrl` `Alt` `S` to open the IDE settings and then select **Editor | Copyright**.

2. Click **+** (or press `Alt` `Insert`), and select an existing shared scope from the list.

    You can define a new scope if necessary. Click the **Select Scopes to add scopes or modify existing ones** link in the lower part of the page.

3. From the **Copyright** list, select the profile that you want to link with the scope.

4. Apply the changes and close the dialog.

<p align="center"><img src="https://resources.jetbrains.com/help/img/idea/2023.3/copyright_dialog.png" alt="copy right" width="80%" height="auto"></p>

After that you can add the copyright to the necessary files.

#### Insert copyright text into files
- To insert the text in a single file, open it in the editor, press `Alt` `Insert`, and select **Copyright** from the popup.

- To insert the text into a group of files, right-click a node in the **Project** tool window, and select **Update Copyright**. You will be prompted to select in which scope you want to update the notice.

    A node may include files that belong to different scopes. In this case, copyright notices will be generated according to the assigned profiles.

    If a node contains a file that doesn't belong to any scope, the IDE will assign the default profile to it.