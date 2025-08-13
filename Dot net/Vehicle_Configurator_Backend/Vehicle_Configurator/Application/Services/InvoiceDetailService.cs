using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Vehicle_Configurator.Application.Interfaces;
using Vehicle_Configurator.Domain.DTOs;
using Vehicle_Configurator.Domain.Entities;
using Vehicle_Configurator.Infrastructure.Repositories;

namespace Vehicle_Configurator.Application.Services
{
    public class InvoiceDetailService : IInvoiceDetailRepository
    {
        private readonly AppDbContext _context;

        public InvoiceDetailService(AppDbContext context)
        {
            _context = context;
        }

        public async Task<ActionResult<IEnumerable<InvoiceDetail>>> GetById(int invoiceDetailId)
        {
            var result = await _context.InvoiceDetail
                .Where(i => i.InvDtlId == invoiceDetailId)
                .ToListAsync();

            return result;
        }

        public async Task<ActionResult<IEnumerable<InvoiceDetail>>> GetByComponentId(int componentId)
        {
            var result = await _context.InvoiceDetail
                .Where(i => i.CompId == componentId)
                .ToListAsync();

            return result;
        }
        public async Task<ActionResult> CreateInvoiceDetails(List<InvoiceDetailDto> invoiceDetails)
        {
            if (invoiceDetails == null || invoiceDetails.Count == 0)
            {
                return new BadRequestResult();
            }

            // Map DTOs to Entities
            var entities = invoiceDetails.Select(dto => new InvoiceDetail
            {
                InvId = dto.InvId,
                CompId = dto.CompId
            }).ToList();

            await _context.InvoiceDetail.AddRangeAsync(entities);
            await _context.SaveChangesAsync();

            return new OkResult();
        }
        





    }
}
