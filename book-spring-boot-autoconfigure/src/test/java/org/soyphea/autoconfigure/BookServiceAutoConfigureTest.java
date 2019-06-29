package org.soyphea.autoconfigure;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.soyphea.book.BookService;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.autoconfigure.logging.ConditionEvaluationReportLoggingListener;
import org.springframework.boot.logging.LogLevel;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
public class BookServiceAutoConfigureTest {


    private ApplicationContextRunner applicationContextRunner = new ApplicationContextRunner()
            .withConfiguration(AutoConfigurations.of(BookServiceAutoConfiguration.class));

    ConditionEvaluationReportLoggingListener initializer = new ConditionEvaluationReportLoggingListener(
            LogLevel.INFO);

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
