name := "hbase-test"
version := "0.1"
scalaVersion := "2.11.7"

resolvers ++= Seq(
  "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos"
)

val hadoopV = "2.6.0-cdh5.4.4"
val hbaseV = "1.0.0-cdh5.4.4"

libraryDependencies ++= Seq(
  "org.scala-lang"    % "scala-library"         % "2.11.7",
  "org.scalatest"     %% "scalatest"            % "2.2.5" % "test",
  "org.apache.hbase"  % "hbase-common"          % hbaseV % "test" classifier "tests",
  "org.apache.hbase"  % "hbase-common"          % hbaseV,
  "org.apache.hbase"  % "hbase-server"          % hbaseV % "test" classifier "tests",
  "org.apache.hbase"  % "hbase-server"          % hbaseV,
  "org.apache.hadoop" % "hadoop-hdfs"           % hadoopV % "test" classifier "tests",
  "org.apache.hadoop" % "hadoop-hdfs"           % hadoopV,
  "org.apache.hbase"  % "hbase-client"          % hbaseV,
  "org.apache.hadoop" % "hadoop-common"         % hadoopV,
  "org.apache.hadoop" % "hadoop-common"         % hadoopV % "test" classifier "tests",
  "org.apache.hbase"  % "hbase-hadoop2-compat"  % hbaseV,
  "org.apache.hbase"  % "hbase-hadoop2-compat"  % hbaseV % "test" classifier "tests",
  "org.apache.hbase"  % "hbase-hadoop-compat"   % hbaseV % "test" classifier "tests",
  "org.apache.hbase"  % "hbase-hadoop-compat"   % hbaseV
)
