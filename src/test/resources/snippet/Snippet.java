package snippet;

public class Snippet {
	<Configuration status="INFO">
	<Properties>
	<Property name="log-path">./logs</Property>
	<Property name="log-pattern">%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}:%L - %m%n</Property>
	</Properties>
	<Appenders>
	<Console name="Console" target="SYSTEM_OUT">
	<PatternLayout pattern="${log-pattern}"/>
	</Console>
	<RollingFile name="File" fileName="${log-path}/automation.log" filePattern="${log-path}/automation-%d{MM-dd-yyyy}-%i.log.gz">
	<PatternLayout pattern="${log-pattern}"/>
	<Policies>
	<TimeBasedTriggeringPolicy/>
	<SizeBasedTriggeringPolicy size="1MB"/>
	</Policies>
	<DefaultRolloverStrategy max="10"/>
	</RollingFile>
	</Appenders>
	<Loggers>
	<Root level="INFO">
	<!-- <AppenderRef ref="Console"/> -->
	<AppenderRef ref="File"/>
	</Root>
	</Loggers>
	</Configuration>
}

