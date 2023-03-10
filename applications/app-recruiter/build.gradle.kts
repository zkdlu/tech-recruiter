apply {
    plugin("kotlin-jpa")
}

dependencies {
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:2021.0.5"))
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.3")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.13.3")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client") // MariaDB
//    runtimeOnly("com.h2database:h2") // H2
//    runtimeOnly("com.microsoft.sqlserver:mssql-jdbc") // MSSQL
//    runtimeOnly("mysql:mysql-connector-java") // MYSQL
//    runtimeOnly("org.postgresql:postgresql") // PostgreSQL
}
