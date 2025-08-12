using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace Vehicle_Configurator.Domain.Entities
{
    [Table("user")]
    public class User
    {
        [Key]
        [Column("id")]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        public long Id { get; set; }

        [Column("username")]
        public string? Username { get; set; }

        [Column("password")]
        public string? Password { get; set; }

        [Column("role")]
        public string? Role { get; set; }

        // Removed 'Holding' as it does not exist in the database diagram.

        [Column("st_no")]
        public int StNo { get; set; }

        [Column("tel")]
        public decimal Tel { get; set; }

        [Column("addr")]
        public string? Addr { get; set; }

        // Removed 'AuthName' as it does not exist in the database diagram.

        [Column("cell")]
        public decimal Cell { get; set; }

        [Column("city")]
        public string? City { get; set; }

        [Column("company_name")]
        public string? CompanyName { get; set; }

        [Column("desig")]
        public string? Desig { get; set; }

        [Column("email")]
        public string? Email { get; set; }

        [Column("pin")]
        public int Pin { get; set; }

        [Column("reg_no")]
        public decimal RegNo { get; set; }

        [Column("state")]
        public string? State { get; set; }
    }
}
