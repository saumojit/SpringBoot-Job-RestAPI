Jointpoint = getAllJobs
Advice = logMethodCall in LoggingAspect
Aspect = LoggingAspect Class
Pointcut = It's expression declared with each advice
Target Object = object for getAllJobs
Proxy = Target Object wrapped with the Proxy Object 
Weaving = This Proxy happens at runtime at SpringBoot ( Weaving can happen at compile/load time)

Types of Advice =>
@Before
@After
@AfterThrowing
@AfterReturning
@Around



Technicals - 
    // https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/advice.html#aop-advice-after-throwing
    // PointCut Expression Syntax -->
    // Pointcut Syntax from Medium Post:
    // - pointcut_designator: execution, within, this, args, target.
    // - modifiers: optional ( private/public etc )

    // pointcut_designator (<modifiers> <return-type> <fully-qualified class-name>.<method-name>(<args>) )
    // we can have multiple pointcut expressions -- @Before("<pointcut-expression-1> || <pointcut-expression-2>")
    // JoinPoint holds the target object

    // Note - Other than arguments -- * means all or anything
    // Note - Specific to arguments (..) :- Zero or more arguments , (*) :- Only one argument , () :- No arguments
    // Example - @Before("execution(* *.*(..))")




