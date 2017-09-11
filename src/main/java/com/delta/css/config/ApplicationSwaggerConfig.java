package com.delta.css.config;

import static com.google.common.collect.Lists.newArrayList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.util.UriComponentsBuilder;

import com.delta.css.utils.CssApiCnst;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spring.web.paths.AbstractPathProvider;
import springfox.documentation.spring.web.paths.Paths;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * MealApi Swagger configuration, without this class swagger will not work.
 * 
 */
@Configuration
public class ApplicationSwaggerConfig implements ServletConfigAware {
	static String SWAGGER_BASE_PATH;

	@Bean
	public springfox.documentation.spring.web.plugins.Docket docket() {
		Docket docket = new Docket(
				springfox.documentation.spi.DocumentationType.SWAGGER_2);

		return docket
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.useDefaultResponseMessages(false)
				.apiInfo(apiInfo())
				.globalResponseMessage(
						RequestMethod.GET,
						newArrayList(
								new ResponseMessageBuilder().code(500)
										.message("System/DB failure")
										.responseModel(new ModelRef("Error"))
										.build(),
								new ResponseMessageBuilder().code(400)
										.message("Invalid Request")
										.responseModel(new ModelRef("Error"))
										.build(),
								new ResponseMessageBuilder().code(401)
										.message("Unauthorized")
										.responseModel(new ModelRef("Error"))
										.build(),
								new ResponseMessageBuilder().code(404)
										.message("Flight not found")
										.responseModel(new ModelRef("Error"))
										.build(),
								new ResponseMessageBuilder()
										.code(200)
										.message(
												"SPML information along with passenger counts in different cabins")
										.responseModel(new ModelRef("Error"))
										.build()))
				.pathProvider(
						new BasePathAwareRelativePathProvider(SWAGGER_BASE_PATH));
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo(CssApiCnst.APP_NAME, CssApiCnst.APP_DESC,
				"1.0", "", "", "", "");
		return apiInfo;
	}

	class BasePathAwareRelativePathProvider extends AbstractPathProvider {
		private String basePath;

		public BasePathAwareRelativePathProvider(String basePath) {
			this.basePath = basePath;
		}

		@Override
		protected String applicationPath() {
			return CssApiCnst.APP_ROOT;
		}

		@Override
		protected String getDocumentationPath() {
			return "/";
		}

		@Override
		public String getOperationPath(String operationPath) {
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
					.fromPath("/");
			
			return Paths.removeAdjacentForwardSlashes(uriComponentsBuilder
					.path(operationPath.replaceFirst(basePath, "")).build()
					.toString());
		}
	}

	public void setServletConfig(ServletConfig servletConfig) {

			String contextPath = servletConfig.getServletContext().getContextPath();
		Collection<String> mappings = servletConfig.getServletContext()
				.getServletRegistration("dispatcher").getMappings();
		List<String> list = new ArrayList(mappings.size());
			list.addAll(mappings);
			String urlPattern = list.get(0).replace("*", "").trim();
			SWAGGER_BASE_PATH = contextPath + urlPattern;

	}
}