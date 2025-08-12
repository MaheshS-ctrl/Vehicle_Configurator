using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Vehicle_Configurator.Application.Interfaces;
using Vehicle_Configurator.Domain.Entities;

namespace Vehicle_Configurator.API.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class InvoiceDetailController : ControllerBase
    {
        private readonly IInvoiceDetailRepository _invoiceDetailRepository;

        public InvoiceDetailController(IInvoiceDetailRepository invoiceDetailRepository)
        {
            _invoiceDetailRepository = invoiceDetailRepository;
        }

        // GET: api/invoicedetail/by-id/{invoiceDetailId}
        /// <summary>
        /// Retrieves invoice detail by its unique ID.
        /// </summary>
        /// <param name="invoiceDetailId">The unique ID of the invoice detail.</param>
        /// <returns>A list of invoice details for the specified ID.</returns>
        [HttpGet("by-id/{invoiceDetailId}")]
        public async Task<ActionResult<IEnumerable<InvoiceDetail>>> GetById(int invoiceDetailId)
        {
            var detailsResult = await _invoiceDetailRepository.GetById(invoiceDetailId);
            var details = detailsResult.Value;

            if (details == null || !details.Any())
            {
                return NotFound($"No invoice details found with ID: {invoiceDetailId}");
            }
            return Ok(details);
        }

        // GET: api/invoicedetail/by-component/{componentId}
        /// <summary>
        /// Retrieves invoice details by their associated component ID.
        /// </summary>
        /// <param name="componentId">The ID of the component.</param>
        /// <returns>A list of invoice details for the specified component.</returns>
        [HttpGet("by-component/{componentId}")]
        public async Task<ActionResult<IEnumerable<InvoiceDetail>>> GetByComponentId(int componentId)
        {
            var detailsResult = await _invoiceDetailRepository.GetByComponentId(componentId);
            var details = detailsResult.Value;

            if (details == null || !details.Any())
            {
                return NotFound($"No invoice details found for component with ID: {componentId}");
            }
            return Ok(details);
        }
    }
}
