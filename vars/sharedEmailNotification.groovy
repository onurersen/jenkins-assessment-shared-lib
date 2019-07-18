import com.onurersen.jenkins.BuildConfig

/**
* This Groovy code 
* simply helps to make Git repository cloning process
* a shared functionality 
*
* @author  Berat Onur Ersen
* @version 1.0
* @since   2019-07-18 
*/

def call(def body = [:]) {

    // evaluate the body block, and collect configuration into the object
    config = BuildConfig.resolve(body)

    echo 'Cloning Repo...'

    emailext (
      to: config.email,
      subject: config.status + ": Job '${env.JOB_NAME} [${env.BUILD_NUMBER}]'",
      body: """<p>Job with name '${env.JOB_NAME} [${env.BUILD_NUMBER}]':</p>
        <p>Check console output at <a href='${env.BUILD_URL}'>${env.JOB_NAME} [${env.BUILD_NUMBER}]</a></p>""",
    )

}