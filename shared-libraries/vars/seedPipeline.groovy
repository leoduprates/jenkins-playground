import org.jenkinsci.plugins.workflow.job.WorkflowJob
import org.jenkinsci.plugins.workflow.cps.CpsFlowDefinition

def call(Map config = [:]) {
    def pipelineScript = """
      pipeline {
        agent any
        stages {
          stage('Example') {
            steps {
              echo 'Hello, World!'
            }
          }
        }
      }
      """

    def myPipeline = createOrUpdatePipeline('my-pipeline', pipelineScript)
    myPipeline.save()
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
