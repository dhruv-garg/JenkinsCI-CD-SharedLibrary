def call (Map config = [:]) {
	def scriptContents = libraryResource "scripts/${config.name}"
	writeFile file: "${config.name}", text: scriptContents
	sh "chmod a+x ./${config.name}"
}
