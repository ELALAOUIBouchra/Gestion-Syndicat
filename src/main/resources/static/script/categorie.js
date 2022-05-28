$(document)
		.ready(
				function() {
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;
					
					table = $('#tcategorie')
							.DataTable({
										ajax : {
											url : URL +"categories/all",
											dataSrc : '',
											type: "GET"
										},
										columns : [
												{
													data : "idCategorie"
												},
												{
													data : "description"
												},
												
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
													}
												},
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-secondary modifier">Affiche</button>';
													}
												} ]

									});

					$('#btn').click(
							function() {
								var description = $("#description");
								
								//if ($('#btn').text() == 'Ajouter') {
									var p = {
										description : description.val()
										
									};

									$.ajax({
										url : 'http://localhost:8090/categories/save',
										contentType : "application/json",
										dataType : "json",
										data : JSON.stringify(p),
										type : 'POST',
										async : false,
										success : function(data, textStatus,
												jqXHR) {
											table.ajax.reload();
										},
										error : function(jqXHR, textStatus,
												errorThrown) {
											console.log(textStatus);
										}
									});
									$("#main-content").load(
											"./page/categorie.html");
								//}
							});
							
							
							$('#btn1').click(
							function() {
								
								console.log("test", id)
								
								var description = $("#description");
								
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										description : description.val(),
										
									};

									$.ajax({
											url :URL + 'categories/edit/'+ id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												table.ajax.reload();
												 
												 $("#description").val('');
								 				
												btn.text('Ajouter');
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#main-content").load(
												"./page/categorie.html");
								//}
							});

							
							
							
							
							

					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {

										var id = $(this).closest('tr').find(
												'td').eq(0).text();
										
															$
																	.ajax({
																		url :URL + 'categories/'+ id,
																				
																		data : {},
																		type : 'DELETE',
																		async : false,
																		success : function(
																				data,
																				textStatus,
																				jqXHR) {
																			if (data
																					.includes("error") == true) {
																				$(
																						"#error")
																						.modal();
																			} else {
																				table.ajax
																						.reload();
																			}
																		},
																		
																	});

													

									});

					$('#table-content').on(
							'click',
							'.modifier',
							function() {
								var btn = $('#btn');
								id = $(this).closest('tr').find('td').eq(0)
										.text();
								
								
								var description = $(this).closest('tr').find('td').eq(
										1).text();
								
								btn.text('Modifier');
								$("#description").val(description);
								$("#id").val(id);
								btn.click(function(e) {
									e.preventDefault();
									 p = {
										id : $("#id").val(),
										code : $("#description").val(),
										
									};
									
								});
							});

				
				});
