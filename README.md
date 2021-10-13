# Junit


Junit:
------
Junit is initial level framework compared with other frameworks it doesn't have much features.

Annotations:
-----------
@BeforeClass --> it will execte before class
@Before   -----> it will exceute before each and every methods or tests
@Test   -------> test script for that particular test case , it will execute in ascending order
@After --------> it will exceute after each and every methods or tests
@AfterClass ---> it will execte after class
@Ignore ------> it will skip particular test
@RunWith  ----> it gives suite to our project
@Suite.SuiteClasses({Flipkart.class,Amazon.class}) ----> by using this you can mention the class name which you want to execute
@JUnitCore.runClasses
Result result = JUnitCore.runClasses(Flipkart.class,Amazon.class);
		
		List<Failure> failures = result.getFailures();
		for (Failure failure : failures) {
			System.out.println(failure);
		}
		
		System.out.println("Total Run count is :"+result.getRunCount());
		System.out.println("Total ignore count is :"+result.getIgnoreCount());
		System.out.println("Total Run Time is :"+result.getRunTime());

Assert:
------
 assert means strict validation
 If assert fails it will not execute the remaining scripts in that particular test

2 Types:
-------
AssertTrue
AssertEqual


Execution Order:
---------------
@BeforeClass
@Before
@Test
@After
@Before
@Test
@After
@AfterClass
