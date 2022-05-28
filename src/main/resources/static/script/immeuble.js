
$(document)
		.ready(
				function() {
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;

					table = $('#timmeuble')
							.DataTable({
										ajax : {
											url :URL +"immeubles/all",
											
											dataSrc : '',
											type: "GET"
										},
										columns : [
												{
													data : "idImmeuble"
												},
												
												{
													data : "nom"
												},
												{
													data : "adresse"
												},
												{
													data : "ville"
												},
												{
													data : "numero"
												},
												
												{
													data : "nbrEtage"
												},
												{
													data : "nbrAppart"
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
								console.log("btn")
			
								var nom = $("#nom");
								var adresse = $("#adresse");
								var ville = $("#ville");
								var numero = $("#numero");
								var nbrEtage = $("#nbrEtage");
								
								var nbrAppart = $("#nbrAppart");
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										nom : nom.val(),
										adresse : adresse.val(),
										ville : ville.val(),
										numero : numero.val(),
										nbrEtage: nbrEtage.val(),
										nbrAppart : nbrAppart.val(), 
										
									};

									$.ajax({
										url : 'http://localhost:8090/immeubles/save',
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
											"./page/immeuble.html");
								//}
							});


							$('#btn1').click(
							function() {
								
								console.log("test")
								var nom = $("#nom");
								var adresse = $("#adresse");
								var ville = $("#ville");
								var numero = $("#numero");
								var nbrEtage = $("#nbrEtage");
								var nbrAppart = $("#nbrAppart");
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										nom : nom.val(),
										adresse : adresse.val(),
										ville : ville.val(),
										numero : numero.val(),
										nbrEtage: nbrEtage.val(),
										nbrAppart : nbrAppart.val(),
									};

									$.ajax({
											url : URL + 'immeubles/edit/' + id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												table.ajax.reload();
												 
												 $("#nom").val(''),
								 				 $("#adresse").val(''),
								 				 $("#ville").val(''),
								 				 $("#numero").val(''),
								 				 $("#nbrEtage").val(''),
								 				 $("#nbrAppart").val('');
												
												btn.text('Ajouter');
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#main-content").load(
												"./page/immeuble.html");
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
																		url : URL + 'immeubles/' + id,
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
								
								var nom = $(this).closest('tr').find('td')
										.eq(1).text();
								var adresse = $(this).closest('tr').find('td')
										.eq(2).text();
								var ville = $(this).closest('tr').find('td')
										.eq(3).text();				
								var numero = $(this).closest('tr').find('td').eq(
										4).text();
								var nbrEtage = $(this).closest('tr').find('td')
										.eq(5).text();
								
								var nbrAppart = $(this).closest('tr').find('td')
								.eq(6).text();
								console.log("mod ", adresse)
							
								
								btn.text('Modifier');
								
								 $("#nom").val(nom),
								 $("#adresse").val(adresse),
								 $("#ville").val(ville),
								 $("#numero").val(numero),
								 $("#nbrEtage").val(nbrEtage),
								$("#nbrAppart").val(nbrAppart),
								$("#id").val(id);
								console.log("mod1")
								btn.click(function(e) {
									console.log("mod2")
									e.preventDefault();
									p = {
										id : $("#id").val(),
									
										nom :  $("#nom").val(),
										adresse : $("#adresse").val(),
										ville : $("#ville").val(),
										numero : $("#numero").val(),
										nbrEtage: $("#nbrEtage").val(),
										nbrAppart : $("#nbrAppart").val(),
										
									};
									//if ($('#btn').text() == 'Modifier') {
										
									//}
								});
							});
});
					
			
				
