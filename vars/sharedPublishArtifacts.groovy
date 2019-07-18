import com.onurersen.jenkins.BuildConfig

/**
* This Groovy code 
* simply turns Nexus Sonatype repository uploading process
* to be a shared functionality 
*
* @author  Berat Onur Ersen
* @version 1.0
* @since   2019-07-18 
*/

def call(def body = [:]) {

    // evaluate the body block, and collect configuration into the object
    config = BuildConfig.resolve(body)

    nexusArtifactUploader(
        nexusVersion: 'nexus3',
        protocol: 'http',
        nexusUrl: config.nexusUrl,
        groupId:  config.groupId,
        version: '${BUILD_NUMBER}',
        repository: config.repository,
        credentialsId: config.credentials,
        artifacts: [
            [artifactId: 'jenkins-assessment',
             classifier: '',
             file: 'target/'+ findFiles(glob: 'target/*')[0].name,
             type: 'jar']
        ]
     )

}