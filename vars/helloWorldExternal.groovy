def call(Map config = [:]) {
	loadTestScript(name: 'helloWorld.sh')
	sh "./helloWorld.sh ${config.name} ${config.dayOfWeek}"
}
