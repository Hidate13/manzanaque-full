package com.educlaas.helpdesk.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educlaas.helpdesk.dao.Caller;
import com.educlaas.helpdesk.dao.Equipment;
import com.educlaas.helpdesk.dao.Operator;
import com.educlaas.helpdesk.dao.Problem;
import com.educlaas.helpdesk.dao.Query;
import com.educlaas.helpdesk.dao.Resolution;
import com.educlaas.helpdesk.dao.Software;
import com.educlaas.helpdesk.dao.Specialist;
import com.educlaas.helpdesk.dao.Users;
import com.educlaas.helpdesk.repository.QueryRepository;
import com.educlaas.helpdesk.service.CallerService;
import com.educlaas.helpdesk.service.EquipmentService;
import com.educlaas.helpdesk.service.OperatorService;
import com.educlaas.helpdesk.service.ProblemService;
import com.educlaas.helpdesk.service.QueryService;
import com.educlaas.helpdesk.service.ResolutionService;
import com.educlaas.helpdesk.service.SoftwareService;
import com.educlaas.helpdesk.service.SpecialistService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(value = "/api")
public class QueryController {

	@Autowired
	private QueryRepository QueryRepository;

	@Autowired
	private QueryService QuerySrv;

	@Autowired
	private CallerService callerSrv;

	@Autowired
	private EquipmentService eqSrv;

	@Autowired
	private SoftwareService swSrv;

	@Autowired
	private OperatorService opSrv;

	@Autowired
	private ProblemService probSrv;

	@Autowired
	private ResolutionService resoSrv;

	@Autowired
	private SpecialistService specialistSrv;

	@PostMapping(value = "/logticket")
	public Query createCallQuery(@RequestBody Query query) throws Exception {
		// Extracting data from the request
		Caller caller = query.getCaller();
		Software software = query.getSoftware();
		Problem problem = query.getProblem();
		Resolution resolution = query.getResolution();
		Operator operator = query.getOperator();
		Users specialist = query.getSpecialist().getUser_id();

		Users usersOp = operator.getUser_id();
		Users usersSp = specialist;

		// get the id from every table
		Equipment tmpEquipment = eqSrv.getSearchBy2Params(query.getEquipment().getEquipmentMake(),
				query.getEquipment().getEquipmentType());
		Software tmpSoftware = swSrv.getSearchBy2Params(query.getSoftware().getSoftwareName(),
				query.getSoftware().getSerialNumber());
		Operator tmpOp = opSrv.findByUserId(usersOp);
//		System.out.println("test usersSp => "+usersSp);
		Specialist tmpSpec = specialistSrv.findByUserId(usersSp);
//		System.out.println("test tmpSpec => "+tmpSpec);

		// Checking if the software has a valid license
		if (software.getSerialNumber().length() == 14) {
			Query queryCall = new Query();

			if (query.getCaller() != null && query.getCaller().getCallerID() == null) {
				callerSrv.saveCaller(caller);
				queryCall.setCaller(caller);
			}

			queryCall.setEquipment(tmpEquipment);
			queryCall.setSoftware(tmpSoftware);

			if (query.getProblem() != null && query.getProblem().getProblemID() == null) {
				// Save the new Problem entity
				probSrv.saveProblem(query.getProblem());
				queryCall.setProblem(problem);
			}

			if (query.getResolution() != null && query.getResolution().getResolutionID() == null) {
				// Save the new resolution entity
				resoSrv.saveResolution(query.getResolution());
				queryCall.setResolution(resolution);
			}

			queryCall.setOperator(tmpOp);

        	queryCall.setSpecialist(tmpSpec);

			queryCall.setCallTime(LocalDateTime.now());

			// queryCall.setProblemNumber(generateProblemNumber());

			/*
			 * //if needed, to generate a unique problem number private String
			 * generateProblemNumber() { //generate a unique problem number return "PRB-" +
			 * UUID.randomUUID().toString(); }
			 */

			// Save the CallQuery
			Query savedCallQuery = QueryRepository.save(queryCall);

			// Log the call
//			logCall(savedCallQuery);

			return savedCallQuery;
		} else {
			throw new Exception("The software does not have a valid license.");
		}
	}

	// Utility method to log the call
	private void logCall(Query queryCall) {
		System.out.println("Call logged successfully. Problem Number: " + queryCall.getProblem().getProblemID());
	}

	@PutMapping(value = "/updatespecialist/{callID}")
	public Query updateQuery(@PathVariable Long callID, @RequestBody Query query) throws Exception {
		// Extracting data from the request

		System.out.println("callID =====> " + callID);
		Query queryCall = QuerySrv.getQueryById(callID);
		System.out.println(queryCall + " test to checking getResolutionID ===>   "
				+ queryCall.getResolution().getResolutionID());
		System.out.println(queryCall + " test to checking rsolutionDesc ===>   "
				+ queryCall.getResolution().getResolutionDescription());

		Resolution resolution = query.getResolution();

		System.out.println("Resolution =====> " + resolution.getResolutionDescription());

//        	if (resolution != null && resolution.getResolutionID() == null) {
//        		if (resolution.getResolutionTime() != null) {
//                    queryCall.getResolution().setResolutionTime(LocalDateTime.now());
//                }
//                if (resolution.getResolutionDescription() != null) {
//                    queryCall.getResolution().setResolutionDescription(resolution.getResolutionDescription());
//                }
//                resoSrv.saveResolution(resolution);
//                queryCall.setResolution(resolution);
//        		
//        	}

		queryCall.getResolution().setResolutionTime(LocalDateTime.now());

		queryCall.getResolution().setResolutionDescription(resolution.getResolutionDescription());
		
//		queryCall.setResolution(resolution);

		// Save the CallQuery
		Query savedCallQuery = QueryRepository.save(queryCall);

		// Log the call
		updateSpecialist(savedCallQuery);

		return savedCallQuery;
	}

	private void updateSpecialist(Query queryCall) {
		System.out.println("Update successfully. Specialist: " + queryCall.getSpecialist());
	}

	@GetMapping("/getlogs")
	public List<Query> getAllQueries() {
		// Get all the Queries
		return QuerySrv.getAllQueries();

	}
	
	
	@DeleteMapping("/deletelog/{callID}")
	public String deleteQuery(@PathVariable Long callID) {
		QuerySrv.deleteQuery(callID);
		return "the Query is deleted";
		
	}
	
	@GetMapping("/getlog/{callID}")
	public Query getQueryByID(@PathVariable Long callID) {
		// Get all the Queries
		return QuerySrv.getQueryById(callID);

	}
	
	@PutMapping("/editedlog/{callID}")
	public Query editedLog(@PathVariable Long callID, @RequestBody Query query ) throws Exception {
		Query existingQuery = QuerySrv.getQueryById(callID);
//		System.out.println("test query ==> " + query.getCallID());
//		System.out.println("test query.getCallID() ==> " + query.getCallID());
//		System.out.println("test query.getCaller() ==> " + query.getCaller());
		// Extracting data from the request
		Caller caller = query.getCaller();
		Software software = query.getSoftware();
		Problem problem = query.getProblem();
		Resolution resolution = query.getResolution();
		Operator operator = query.getOperator();
		Users specialist = query.getSpecialist().getUser_id();

		Users usersOp = operator.getUser_id();
		Users usersSp = specialist;

		// get the id from every table
		Equipment tmpEquipment = eqSrv.getSearchBy2Params(query.getEquipment().getEquipmentMake(),
				query.getEquipment().getEquipmentType());
		Software tmpSoftware = swSrv.getSearchBy2Params(query.getSoftware().getSoftwareName(),
				query.getSoftware().getSerialNumber());
		Operator tmpOp = opSrv.findByUserId(usersOp);
		Specialist tmpSpec = specialistSrv.findByUserId(usersSp);

		// Checking if the software has a valid license
		if (software.getSerialNumber().length() == 14) {
			if (query.getCaller() != null) {
				existingQuery.setCaller(caller);
				if(existingQuery.getCaller() != null) {
					callerSrv.saveCaller(caller);
				}				
			}else {
				System.out.println(query.getCaller() + " <===== the query.getCaller() is null");
			}

			existingQuery.setEquipment(tmpEquipment);
			if(existingQuery.getEquipment() != null) {
				eqSrv.saveEquipment(tmpEquipment);
			}
			
			existingQuery.setSoftware(tmpSoftware);
			if(existingQuery.getSoftware() != null) {
				swSrv.saveSoftware(tmpSoftware);
			}
			
			existingQuery.setProblem(problem);
			if(existingQuery.getProblem() != null) {
				probSrv.saveProblem(problem);
			}
			
			existingQuery.setResolution(resolution);
			if(existingQuery.getResolution() != null) {
				resoSrv.saveResolution(resolution);
			}

			existingQuery.setOperator(tmpOp);
			if(existingQuery.getOperator() != null) {
				opSrv.saveOperator(tmpOp);
			}

        	existingQuery.setSpecialist(tmpSpec);
        	if(existingQuery.getSpecialist() != null) {
        		specialistSrv.saveSpecialist(tmpSpec);
        	}

			existingQuery.setCallTime(LocalDateTime.now());

			// existingQuery.setProblemNumber(generateProblemNumber());

			/*
			 * //if needed, to generate a unique problem number private String
			 * generateProblemNumber() { //generate a unique problem number return "PRB-" +
			 * UUID.randomUUID().toString(); }
			 */


			// Log the call
//			System.out.println("try to save edited data ===> " + existingQuery  );

			return QuerySrv.saveQeries(existingQuery);
		} else {
			throw new Exception("The software does not have a valid license.");
		}
		
	}
}
