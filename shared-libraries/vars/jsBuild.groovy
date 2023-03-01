def call(Map config = [:]) {
  pipeline {
      environment {
          PUPPETEER_SKIP_DOWNLOAD = 'true'
      }
      agent {
          docker { image config.image }
      }
      parameters {
          string(name: 'BRANCH', defaultValue: 'main', description: 'Branch to build')
      }
      stages {
          stage('Checkout') {
              steps {
                  git(url: config.repo, branch: BRANCH)
              }
          }
          stage('Install Dependencies') {
              steps {
                  sh('npm install')
              }
          }
          stage('Run Unit Tests') {
              steps {
                  sh('npm run test:unit')
              }
          }
          stage('Run Integration Tests') {
              steps {
                  sh('npm run test:integration')
              }
          }
          stage('Run Test Coverage') {
              steps {
                  sh('npm run coverage -- --testPathIgnorePatterns "./tests/e2e/"')
              }
          }
      }
  }
}
