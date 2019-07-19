**Shared Libraries Used in Jenkins Assessment Project**

**BuildConfig.groovy** in src/com/onurersen/jenkins folder helps to handle parameters coming from pipeline script and being used in shared library functionalities

Inside **vars** folder, there are 3 Groovy files created to share 3 functionalies across Jenkins instance.

1. **sharedCloneRepository.groovy**
1. **sharedEmailNotification.groovy**
1. **sharedPublishArtifacts.groovy**

Functionalities implemented in those Groovy file are as straight forward and obvious as their names.

This repository is defined on Jenkins instance at following location :
Managed Jenkins -> Configure System -> Global Pipeline Libraries

By putting **@Library('jenkins-assessment-shared-lib')** on top of Pipeline script, we are able to use this shared library in each and every Pipeline.
