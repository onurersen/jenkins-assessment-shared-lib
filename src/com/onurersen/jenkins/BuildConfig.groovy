package com.onurersen.jenkins
import com.cloudbees.groovy.cps.NonCPS

/**
* This Groovy code 
* helps to handle parameters coming from 
* pipeline script and being used in shared library functionalities
*
* @author  Berat Onur Ersen
* @version 1.0
* @since   2019-07-18 
*/

class BuildConfig implements Serializable {
    static Map resolve(def body = [:]) {

        Map config = [:]
        config = body
        if (body in Map) {
            config = body
        } else if (body in Closure) {
            body.resolveStrategy = Closure.DELEGATE_FIRST
            body.delegate = config
            body()
        } else {
            throw  new Exception(sprintf("Unsupported build config type:%s", [config.getClass()]))
        }
        return config
    }
}