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

    git branch: config.branch, credentialsId: config.credentials, url: config.url

}