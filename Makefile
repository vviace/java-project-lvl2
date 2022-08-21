.DEFAULT_GOAL := build-install

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-app:
	./build/install/app/bin/app -h

diff-json:
	./build/install/app/bin/app ./src/test/resources/file1.json ./src/test/resources/file2.json

diff-json-stylish:
	./build/install/app/bin/app -f stylish ./src/test/resources/file1.json ./src/test/resources/file2.json

diff-json-plain:
	./build/install/app/bin/app -f plain ./src/test/resources/file1.json ./src/test/resources/file2.json

diff-yml:
	./build/install/app/bin/app ./src/test/resources/file1.yml ./src/test/resources/file2.yml

diff-yml-stylish:
	./build/install/app/bin/app -f stylish ./src/test/resources/file1.yml ./src/test/resources/file2.yml

diff-yml-plain:
	./build/install/app/bin/app -f plain ./src/test/resources/file1.yml ./src/test/resources/file2.yml

diff-yml-json:
	./build/install/app/bin/app -f json ./src/test/resources/file1.yml ./src/test/resources/file2.yml

diff-json-output:
	./build/install/app/bin/app -f json ./src/test/resources/file1.json ./src/test/resources/file2.json

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions

build-install: update-deps build install

.PHONY: build