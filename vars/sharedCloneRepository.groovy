import com.onurersen.jenkins.BuildConfig

def call(def body = [:]) {
    // evaluate the body block, and collect configuration into the object
    config = BuildConfig.resolve(body)
    git branch: config.branch, credentialsId: config.credentials, url: config.url
}