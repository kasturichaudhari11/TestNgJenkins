pipeline {
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2"
    }
    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url:' https://github.com/kasturichaudhari11/TestNgJenkins.git'
                
                // Run Maven on a Unix agent.
                // sh "mvn test"
                // To run Maven on a Windows agent, use
                //bat "mvn -Dmaven.test.failure.ignore=true clean package"
                bat "mvn test"
            }
        }
    }
}