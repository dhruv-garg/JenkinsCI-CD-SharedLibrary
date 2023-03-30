def call(Map config = [:]) {
	loadDockerScript(name: 'dockerBuild.sh')
	sh "./dockerBuild.sh ${config.Username} ${config.project}"
}
