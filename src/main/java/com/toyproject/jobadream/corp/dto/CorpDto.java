package com.toyproject.jobadream.corp.dto;

import lombok.Data;
import java.util.List;



@Data
public class CorpDto {
	private String id;
	private String name;
	private List<JobDto> jobs;  // 연관된 Job 데이터를 포함할 수 있습니다

	@Data
	public static class JobDto {
		private String corpId;
		private String id;
		private String corpName;
		private String title;
		private String position;
		private List<JobUrlDto> jobUrls;  // Job에 연결된 URL 리스트 포함

		@Data
		public static class JobUrlDto {
			private  String jobId;
			private String id;
			private String platformName;
			private String url;
		}
	}
}


