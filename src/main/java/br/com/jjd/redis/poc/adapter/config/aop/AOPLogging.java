package br.com.jjd.redis.poc.adapter.config.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class AOPLogging {
    private static final Logger LOGGER = LogManager.getLogger(AOPLogging.class);

    @Around("execution(* br.com.jjd..*(..)))")
    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        final StopWatch stopWatch = new StopWatch();

        //Calcula o tempo
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        //Tempo de execução
        LOGGER.info("Tempo de execução de "
                + methodSignature.getDeclaringType().getSimpleName()
                + "." + methodSignature.getName() + " "
                + ":: " + stopWatch.getTotalTimeMillis() + " ms");

        return result;
    }
}
