# Self-Hosted GitHub Action Runner

## Articles:
1. https://github.com/features/actions
2. https://docs.github.com/en/actions
3. https://docs.github.com/en/actions/learn-github-actions/understanding-github-actions


## GitHub Actions runner setup instructions

1. Install all latest updates
```
$ sudo apt update
$ apt list --upgradable
$ sudo apt upgrade
```

2. Install required software
```
$ sudo apt install htop mc git
$ sudo apt install openjdk-11-jdk
$ java --version
$ sudo apt install maven
$ mvn --version
```

3. Install GitHub Action runner binary
```
$ mkdir actions-runner && cd actions-runner
$ curl -o actions-runner-linux-x64-2.305.0.tar.gz -L https://github.com/actions/runner/releases/download/v2.305.0/actions-runner-linux-x64-2.305.0.tar.gz
$ echo "737bdcef6287a11672d6a5a752d70a7c96b4934de512b7eb283be6f51a563f2f  actions-runner-linux-x64-2.305.0.tar.gz" | shasum -a 256 -c
$ tar xzf ./actions-runner-linux-x64-2.305.0.tar.gz
$ rm actions-runner-linux-x64-2.305.0.tar.gz
$ ./config.sh --url https://github.com/Mak0/automation-workshop --token
```

4. Install Google Chrome with all required dependencies
```
$ wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb
$ sudo dpkg -i google-chrome-stable_current_amd64.deb
$ sudo apt install -y unzip xvfb libxi6 libgconf-2-4
$ sudo apt --fix-broken install
$ sudo dpkg -i google-chrome-stable_current_amd64.deb
```

5. Install chromedriver
```
$ wget https://chromedriver.storage.googleapis.com/114.0.5735.90/chromedriver_linux64.zip
$ unzip chromedriver_linux64.zip
$ sudo mv chromedriver /usr/local/bin/
$ chromedriver --version
```

6. Run GitHub Action Runner
```
$ cd actions-runner/
$ ./run
```

7. Run GitHub Action Runner as a Linux Service
```
$ cd actions-runner
$ sudo ./svc.sh install
$ sudo ./svc.sh start
```


## Contacts:
Email to /dev/null

