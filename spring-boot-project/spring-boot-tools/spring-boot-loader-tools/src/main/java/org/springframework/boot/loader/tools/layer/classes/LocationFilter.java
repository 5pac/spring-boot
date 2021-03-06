/*
 * Copyright 2012-2020 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.boot.loader.tools.layer.classes;

import java.util.List;

import org.springframework.util.AntPathMatcher;

/**
 * An implementation of {@link ResourceFilter} based on the resource location.
 *
 * @author Madhura Bhave
 * @since 2.3.0
 */
public class LocationFilter extends AbstractResourceFilter {

	private static final AntPathMatcher MATCHER = new AntPathMatcher();

	public LocationFilter(List<String> includes, List<String> excludes) {
		super(includes, excludes);
	}

	@Override
	protected boolean isMatch(String resourceName, List<String> toMatch) {
		return toMatch.stream().anyMatch((pattern) -> MATCHER.match(pattern, resourceName));
	}

}
