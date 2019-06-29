# Spring Boot Auto-Configure

## Getting Start
### Create a book-service
```
public class BookService {


    private BookConfig bookConfig;

    public BookService(BookConfig bookConfig){
        this.bookConfig = bookConfig;
    }

    public Book getContent(){
        Book book = new Book(
                bookConfig.get(BookConfigParams.BOOK_TITLE).toString(),
                bookConfig.get(BookConfigParams.BOOK_AUTHOR).toString(),
                bookConfig.get(BookConfigParams.BOOK_price).toString());
        return book;

    }

}
```
### Create BookServiceAutoConfiguration
```
@Configuration
@ConditionalOnClass(BookService.class)
@EnableConfigurationProperties(BookProperties.class)
public class BookServiceAutoConfiguration {
    @Autowired
    BookProperties bookProperties;

    @Bean
    @ConditionalOnMissingBean
    public BookConfig bookConfig(){
        System.out.println("Initialized bean book config");
        String title = bookProperties.getTitle() == null? "Default title": bookProperties.getTitle();
        String author = bookProperties.getAuthor()==null? "Default author": bookProperties.getAuthor();
        String price = bookProperties.getPrice()==null? "0.00": bookProperties.getPrice();

        BookConfig bookConfig = new BookConfig();
        bookConfig.setProperty(BOOK_TITLE,title);
        bookConfig.setProperty(BOOK_AUTHOR,author);
        bookConfig.setProperty(BOOK_price,price);
        return bookConfig;
    }

    @ConditionalOnMissingBean
    @Bean
    BookService bookService(BookConfig bookConfig){
        System.out.println("Initialized bean book BookService");
        BookService bookService = new BookService(bookConfig);
        return bookService;
    }

}
```

### Testing Your spring boot auto-configure
```
@RunWith(SpringRunner.class)
public class BookServiceAutoConfigureTest {

    private ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(BookServiceAutoConfiguration.class));

    @Test
    public void whenPropertiesSetThenShouldContainFromProperties(){
        this.applicationContextRunner.withPropertyValues("book.service.title=boot-auto").run( context -> {
                    assertThat(context).hasSingleBean(BookService.class);
                    assertAll("All books content should match",
                            () -> assertThat(context.getBean(BookService.class).getContent().getTitle()).isEqualTo("boot-auto"),
                            () -> assertThat(context.getBean(BookService.class).getContent().getPrice()).isEqualTo("0.00"));
                }
        );
    }
    
    @Test
    public void serviceIsIgnoredIfLibraryIsNotPresent() {
        this.applicationContextRunner
                .withClassLoader(new FilteredClassLoader(BookService.class))
                .run((context) -> assertThat(context)
                        .doesNotHaveBean("bookService"));
    }
}
```
