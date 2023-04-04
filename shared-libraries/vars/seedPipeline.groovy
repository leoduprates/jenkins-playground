import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition

def call(Map config = [:]) {
    pipeline {
        agent any
        stages {
            stage('build') {
                steps {
                    script {
                        git(branch: 'main', url: 'https://github.com/leoduprates/jenkins-playground.git')

                        def yaml = readYaml(file: './pipelines.yaml')

                        yaml.pipeline.each { pipeline ->
                            def pipelineScript = """
                                pipeline {
                                agent ${pipeline.agent}
                                    stages {
                                      stage('Example') {
                                        steps {
                                          echo '${pipeline.message}'
                                        }
                                      }
                                    }
                                }
                                """

                            def myPipeline = createOrUpdatePipeline(pipeline.name, pipelineScript)
                            myPipeline.save()
                        }
                    }
                }
            }
        }
    }
}

def createOrUpdatePipeline(String name, String script) {
    def job = Jenkins.instance.getItemByFullName(name)

    if (job) {
        job.setDefinition(new CpsFlowDefinition(script, true))
    } else {
        job = Jenkins.instance.createProject(WorkflowJob.class, name)
        job.setDefinition(new CpsFlowDefinition(script, true))
    }
    job.save()
    return job
}
