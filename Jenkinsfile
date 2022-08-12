pipeline {
  
  agent any
  
  tools { 
        maven 'maven3.8.6'
    }
  
  stages {
    
    stage("build") {
      steps {
        echo 'building the app...'
             sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                    echo "JAVA_HOME = ${JAVA_HOME}"
                '''
             sh 'mvn clean package -DskipTests'
      }
    }
    
    stage("test") {
      steps {
        echo 'testing the app...'
        sh 'mvn test'
      }
    }
    
    stage('reports') {
    steps {
       script {
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'target/allure-results']]
            ])
      }
    }
}

    
  }
  
  post{
    always {
   
                echo 'Hello World'
                emailext(attachLog: true, 
                body: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS: Check console output at $BUILD_URL to view the results.',
                subject: '$PROJECT_NAME - Build # $BUILD_NUMBER - $BUILD_STATUS!', 
                to: '40514972@live.napier.ac.uk')
            
    }
  }
}
