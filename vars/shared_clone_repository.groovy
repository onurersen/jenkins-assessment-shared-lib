def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    echo config.branch
    echo config.credentials
    echo config.url
    //echo "Param1 is: ${env.param1}"
    //echo "Param2 is: ${env.param2}"
    git branch: config.branch, credentialsId: config.credentials, url: config.url
    /*if (env.param1 == 'One default') {
        echo "Param1 is default"
    }*/
    return this
}
