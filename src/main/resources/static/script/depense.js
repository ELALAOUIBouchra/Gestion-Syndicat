$(document)
		.ready(
				function() {
					
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;


					table = $('#tdepense')
							.DataTable({
										ajax : {
											url :URL+ "depenses/all",
											dataSrc : '',
											type: "GET"
										},
										columns : [
												{
													data : "idDepense"
												},
												{
													data : "description"
												},
												{
													data : "montant"
												},
												{
													data : "dateDepense"
												},
												{
													data : "immeuble.nom"
												},
												{
													data : "categorie.description"
												},
												
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-danger supprimer">Supprimer</button>';
													}
												},
												{
													"render" : function() {
														return '<button type="button" class="btn btn-outline-secondary modifier">affiche</button>';
													}
												} ]

									});
					$.ajax({
						url:'/immeubles/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.idImmeuble+'>'+e.nom+'</option>';
							});
							
						$('#immeuble').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});	
					
					$.ajax({
						url:'/categories/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.idCategorie+'>'+e.description+'</option>';
							});
							
						$('#categorie').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});				
									

					$('#btn').click(
							function() {
								var description = $("#description");
								var montant = $("#montant");
								var dateDepense = $("#dateDepense");
								var immeuble = $("#immeuble");
								var categorie = $("#categorie");

								//if ($('#btn').text() == 'Ajouter') {
									var p = {
										description : description.val(),
										montant : montant.val(),
										dateDepense : dateDepense.val(),
										immeuble : {
											idImmeuble : parseInt(immeuble.val())
										},
										categorie : {
											idCategorie : parseInt(categorie.val())
										}
										
									};

									$.ajax({
										url : URL+'depenses/save',
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
											"./page/depense.html");
								//}
							});

						$('#btn1').click(
							function() {
								
								console.log("test")
								var description = $("#description");
								var montant = $("#montant");
								var dateDepense = $("#dateDepense");
								var immeuble = $("#immeuble");
								var categorie = $("#categorie");
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										description : description.val(),
										montant : montant.val(),
										dateDepense : dateDepense.val(),
										immeuble : {
											idImmeuble : parseInt(immeuble.val())
										},
										categorie : {
											idCategorie : parseInt(categorie.val())
										}
									};

									$.ajax({
											url : URL + 'depenses/edit/' + id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												//table.ajax.reload();
												 
												 $("#description").val('');
												$("#montant").val('');
												$("#dateDepense").val('');
												$("#immeuble").val('');
												$("#categorie").val('');
												
												
												btn.text('Ajouter');
												console.log("in")
												table.ajax
														.reload();
											},
											error : function(jqXHR, textStatus,
													errorThrown) {
												console.log(textStatus);
											}
										});
										$("#trevenu").load(
												"./page/depense.html ");
												
								//}
							});

                       







					$('#table-content')
							.on(
									'click',
									'.supprimer',
									function() {

										var id = $(this).closest('tr').find(
												'td').eq(0).text();
										
																	$.ajax({
																		url :URL+ 'depenses/'+ id,
																				
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
								;
								var description = $(this).closest('tr').find('td').eq(
										1).text();
								var montant = $(this).closest('tr').find('td')
										.eq(2).text();
								
								var dateDepense = $(this).closest('tr')
										.find('td').eq(3).text().replace(" ",
												"T");
								var immeuble = $(this).closest('tr').find('td')
										.eq(4).text();
								var categorie = $(this).closest('tr').find('td')
										.eq(5).text();
								btn.text('Modifier');
								$("#description").val(description);
								$("#montant").val(montant);
								$("#id").val(id);
								$("#dateDepense").val(dateDepense);
								var op = $('#immeuble option').filter(function () { return $(this).html() == immeuble; }).val();
								$("#immeuble").val(op);
								
								var op1 = $('#categorie option').filter(function () { return $(this).html() == categorie; }).val();
								$("#categorie").val(op1);
								
								btn.click(function(e) {
									e.preventDefault();
									var p = {
										id : $("#id").val(),
										code : $("#description").val(),
										nom : $("#montant").val(),
										dateDepense : $("#dateDepense").val(),
										appartement : {
											id : $("#immeuble").val()
											
										},
										categorie : {
											id : $("#categorie").val()
											
										}
									
									};
									
								});
							});

				
				});
