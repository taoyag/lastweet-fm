import sbt._

//class Project(info: ProjectInfo) extends ParentProject(info) with IdeaPlugin {
//  lazy val subProject = project("subproject", "subproject", new DefaultProject(_) with IdeaPlugin)
  //lazy val subProject = project("subproject", "subproject", new DefaultWebProject(_) with IdeaPlugin)

class Project(info: ProjectInfo) extends DefaultWebProject(info) with IdeaPlugin {
  override def ivyXML =
    <dependencies>
      <dependency org="org.apache.httpcomponents" name="httpclient" rev="4.0">
        <exclude org="commons-logging" name="commons-logging"/>
      </dependency>
      <dependency org="junit" name="junit" rev="4.7">
        <exclude org="commons-logging" name="commons-logging"/>
        <exclude org="org.slf4j" name="slf4j-api"/>
        <exclude org="org.slf4j" name="slf4j-nop"/>
      </dependency>
    </dependencies>

  val springVersion = "3.0.0.RELEASE"
  val aspectjVersion = "1.6.7"

  val scala = "org.scala-lang" % "scala-compiler" % "2.7.7" % "test"
  val httpclient = "org.apache.httpcomponents" % "httpclient" % "4.0" % "compile"
  val jcip = "net.jcip" % "jcip-annotations" % "1.0" % "compile"
  val slf4j = "org.slf4j" % "slf4j-api" % "1.5.8" % "compile"
  val jclOverSlf4j = "org.slf4j" % "jcl-over-slf4j" % "1.5.8" % "compile"
  val logbackCore = "ch.qos.logback" % "logback-core" % "0.9.17" % "compile"
  val logbackClassic = "ch.qos.logback" % "logback-classic" % "0.9.17" % "compile"

  val junit = "junit" % "junit" % "4.7" % "test"
  val scalatest = "org.scalatest" % "scalatest" % "1.0" % "test"

  //  Spring framework
  val springCore = "org.springframework" % "spring-core" % springVersion
  val springContext = "org.springframework" % "spring-context" % springVersion
  val springTx = "org.springframework" % "spring-tx" % springVersion
  val springWeb = "org.springframework" % "spring-web" % springVersion
  val springAspects = "org.springframework" % "spring-aspects" % springVersion
  val asm = "asm" % "asm" % "3.2"
  //  Spring security
  val securityCore = "org.springframework.security" % "spring-security-core" % springVersion
  val securityConfig = "org.springframework.security" % "spring-security-config" % springVersion
  val securityWeb = "org.springframework.security" % "spring-security-web" % springVersion

  //  AspectJ
  val aspectjTools = "org.aspectj" % "aspectjtools" % aspectjVersion % "provided"
  val aspectjRt = "org.aspectj" % "aspectjrt" % aspectjVersion
  val aspectjWeaver = "org.aspectj" % "aspectjweaver" % aspectjVersion

  //  GCLIB
  val cglib = "cglib" % "cglib-nodep" % "2.2"

  //  Bean Validation API/Implementation
  val validation = "javax.validation" % "validation-api" % "1.0.0.GA"
  val validationImpl = "org.hibernate" % "hibernate-validator" % "4.0.2.GA"

  //  Dependency Injection (JSR 330)
  val inject = "javax.inject" % "javax.inject" % "1"
  val annotation = "org.glassfish" % "javax.annotation" % "3.0"

  //  JSF2.0
  val jsfApi = "com.sun.faces" % "jsf-api" % "2.0.2"
  val jsfImpl = "com.sun.faces" % "jsf-impl" % "2.0.2"
  val elApi = "javax.el" % "el-api" % "2.2"
  val elImpl = "org.glassfish.web" % "el-impl" % "2.2"

  val servlet = "javax.servlet" % "servlet-api" % "2.5" % "provided"
  val jsp = "javax.servlet.jsp" % "jsp-api" % "2.1" % "provided"
  val jstl = "javax.servlet" % "jstl" % "1.2" % "provided"
  val jetty7 = "org.mortbay.jetty" % "jetty" % "7.0.0pre2" % "test"
  val jetty7jsp = "org.mortbay.jetty" % "jsp-2.1" % "7.0.0pre2" % "test"
  //val jetty6 = "org.mortbay.jetty" % "jetty" % "[6.1.6, 6.1.19)" % "test"

  val smackRepo = "m2-repository-smack" at "http://maven.reucon.com/public"
  val javanetRepo = "java.net.m2" at "http://download.java.net/maven/2"
  val glassfishRepo = "java.net.glassfish.m2" at "http://download.java.net/maven/glassfish"
  val jbossRepo = "repository.jboss.org" at "http://repository.jboss.org/maven2"
}

