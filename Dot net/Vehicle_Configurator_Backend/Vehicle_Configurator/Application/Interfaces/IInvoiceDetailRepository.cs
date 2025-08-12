using System.Collections.Generic;
using Vehicle_Configurator.Domain.Entities;
using Microsoft.AspNetCore.Mvc;
namespace Vehicle_Configurator.Application.Interfaces
{
    public interface IInvoiceDetailRepository
    {
        Task<ActionResult<IEnumerable<InvoiceDetail>>> GetById(int invoiceDetailId);
        Task<ActionResult<IEnumerable<InvoiceDetail>>> GetByComponentId(int componentId);
    }
}
