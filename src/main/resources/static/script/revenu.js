$(document)
		.ready(
				function() {
					console.log("tesy")
					$.noConflict();
					const URL = "http://localhost:8090/";
					var id;

					table = $('#trevenu')
							.DataTable({
										ajax : {
											url : URL+ "revenus/all",
											dataSrc : ''
										},
										columns : [
												{
													data : "idRevenu"
												},
												{
													data : "commentaire"
												},
												{
													data : "somme"
												},
												{
													data : "dateRevenu"
												},
												{
													data : "appartement.numero"
												},
												{
													data : "residant.email"
												},
												{
													data : "immeuble.nom"
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
									
						$.ajax({
						url:'/appartements/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.idAppartement+'>'+e.numero+'</option>';
							});
							
						$('#appartement').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
					});			
									
						$.ajax({
						url:'/residants/all',
						type:'GET',
						success : function(data) {
							var option = '';
							data.forEach(e=>{
								option += '<option value ='+e.idResidant+'>'+e.email+'</option>';
							});
							
						$('#residant').append(option);
						},
						error : function(jqXHR, textStatus,
								errorThrown) {
							console.log(textStatus);
						}
						
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
									
									

					$('#btn').click(
							function() {
								var commentaire = $("#commentaire");
								var somme = $("#somme");
								var dateRevenu = $("#dateRevenu");
								var appartement = $("#appartement");
								var residant = $("#residant");
								var immeuble = $("#immeuble");
								//if ($('#btn').text() == 'Ajouter') {
									var p = {
										commentaire : commentaire.val(),
										somme : somme.val(),
										dateRevenu : dateRevenu.val(),
										appartement : {
											idAppartement : parseInt(appartement.val())
										},
										residant : {
											idResidant : parseInt(residant.val())
										},
										immeuble : {
											idImmeuble : parseInt(immeuble.val())
										}
										
									};

									$.ajax({
										url : URL+'revenus/save',
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
											"./page/revenu.html");
								//}
							});

						$('#btn1').click(
							function() {
								
								console.log("test")
								var commentaire = $("#commentaire");
								var somme = $("#somme");
								var dateRevenu = $("#dateRevenu");
								var appartement = $("#appartement");
								var residant = $("#residant");
								var immeuble = $("#immeuble");
								//if ($('#btn').text() == 'Ajouter immeuble') {
									var p = {
										
										commentaire : commentaire.val(),
										somme : somme.val(),
										dateRevenu : dateRevenu.val(),
										appartement : {
											idAppartement : parseInt(appartement.val())
										},
										residant : {
											idResidant : parseInt(residant.val())
										},
										immeuble : {
											idImmeuble : parseInt(immeuble.val())
										}
									};

									$.ajax({
											url : URL + 'revenus/edit/' + id,
											contentType : "application/json",
											dataType : "json",
											data : JSON.stringify(p),
											type : 'PUT',
											async : false,
											success : function(data,
													textStatus, jqXHR) {
												//table.ajax.reload();
												 
												 $("#commentaire").val('');
												$("#somme").val('');
												$("#dateRevenu").val('');
												$("#appartement").val('');
												$("#residant").val('');
												$("#immeuble").val('');
												
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
												"./page/revenu.html ");
												
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
																		url :URL+ 'revenus/'+ id,
																				
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
																		error : function(
																				jqXHR,
																				textStatus,
																				errorThrown) {
																			$(
																					"#error")
																					.modal();
																		}
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
								var commentaire = $(this).closest('tr').find('td').eq(
										1).text();
								var somme = $(this).closest('tr').find('td')
										.eq(2).text();
								
								var dateRevenu = $(this).closest('tr')
										.find('td').eq(3).text().replace(" ",
												"T");
								var appartement = $(this).closest('tr').find('td')
										.eq(4).text();
								var residant = $(this).closest('tr').find('td')
										.eq(5).text();
								var immeuble = $(this).closest('tr').find('td')
								.eq(6).text();
											
												
								btn.text('Modifier');
								$("#commentaire").val(commentaire);
								$("#somme").val(somme);
								$("#id").val(id);
								$("#dateRevenu").val(dateRevenu);
								var op = $('#appartement option').filter(function () { return $(this).html() == appartement; }).val();
								$("#appartement").val(op);
								
								var op1 = $('#residant option').filter(function () { return $(this).html() == residant; }).val();
								$("#residant").val(op1);
								var op2 = $('#immeuble option').filter(function () { return $(this).html() == immeuble; }).val();
								$("#immeuble").val(op2);
								btn.click(function(e) {
									e.preventDefault();
									
									var p = {
										id : $("#id").val(),
										code : $("#commentaire").val(),
										nom : $("#somme").val(),
										dateDepense : $("#dateRevenu").val(),
										appartement : {
											id : $("#appartement").val()
											
										},
										residant : {
											id : $("#residant").val()
											
										},
										immeuble : {
											id : $("#immeuble").val()
											
										}
									
									};
									
								});
							});

				
				});
