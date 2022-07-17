.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-project-lvl2/bin/java-project-lvl2 -h

run-dis:
	./build/install/java-project-lvl2/bin/java-project-lvl2 ~/java-project-lvl2/src/test/resources/file1.json ~/java-project-lvl2/src/test/resources/file2.json

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions

build-run: build run

.PHONY: build