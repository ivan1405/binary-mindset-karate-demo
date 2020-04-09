pipeline {

    agent { label "master" }

    tools {
        maven 'Maven-LATEST'
    }

    parameters {
        choice(
                choices: ['dev', 'preprod'],
                description: 'Choose an environment please',
                name: 'Environment'
        )
        string(
                name: 'RAMP_USERS',
                description: 'Number of users to inject',
                defaultValue: '20'
        )
        string(
                name: 'RAMP_DURATION',
                description: 'Duration of the injection',
                defaultValue: '5'
        )
    }

    stages {

        stage('Maven build') {
            steps {
                sh "mvn clean test-compile"
            }
        }

        stage('Load test') {
            steps {
                script {
                    sh "mvn gatling:test -Denv=${params.Environment} -DrampUpUsers=${params.RAMP_USERS} -DrampUpDuration=${params.RAMP_DURATION}"
                }
            }
        }

    }
    post {
        always {
            gatlingArchive()
        }
    }
}