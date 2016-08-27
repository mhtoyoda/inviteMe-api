package br.com.application.indexer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.stereotype.Service;

@Service
public class Indexer<T> {

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	public void index(String type, String id, T classMapping){
		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setIndexName("resource");
		indexQuery.setType(type);
		indexQuery.setId(id);
		indexQuery.setObject(classMapping);
		elasticsearchTemplate.index(indexQuery);
		elasticsearchTemplate.refresh(classMapping.getClass(), true);
	}

}
