package domain;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BackendFrontend {
	private Boolean success;
	private String message;
	private Object object;
	private List<Object> list;	
}
