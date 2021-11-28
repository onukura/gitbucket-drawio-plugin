# gitbucket-drawio-plugin

A GitBucket plugin for rendering Draw.io file.

Based on [Diagram renderer](https://github.com/laingsimon/render-diagram).

## Screenshot

![screenshot](https://github.com/onukura/gitbcket-drawio-plugin/blob/assets/screenshot.png?raw=true)

## Install

1. Download *.jar from Releases.
2. Deploy it to `GITBUCKET_HOME/plugins`.
3. Restart GitBucket.

## Build from source

```sbt
sbt assembly
```

This makes the assembly package
`target/scala-2.13/gitbucket-drawio-plugin-{plugin-version}.jar`
for deployment.

## Usage

This plugin process files with `.drawio` extension.

## Version

Plugin version|GitBucket version
:---|:---
0.1.x |4.36.x -