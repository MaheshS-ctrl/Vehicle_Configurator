import { Button } from "@/components/ui/button";
import { Car, User, Phone, FileText } from "lucide-react";

interface HeaderProps {
  onSignIn?: () => void;
  onAboutUs?: () => void;
  onContact?: () => void;
  onRegistration?: () => void;
}

export const Header = ({ onSignIn, onAboutUs, onContact, onRegistration }: HeaderProps) => {
  return (
    <header className="w-full bg-background border-b border-border shadow-card">
      <div className="container mx-auto px-4 py-4">
        <div className="flex items-center justify-between">
          {/* Logo */}
          <div className="flex items-center gap-3">
            <div className="w-10 h-10 bg-gradient-primary rounded-lg flex items-center justify-center">
              <Car className="w-6 h-6 text-primary-foreground" />
            </div>
            <div>
              <h1 className="text-xl font-bold text-foreground">V-CONF</h1>
              <p className="text-xs text-muted-foreground">Vehicle Configurator</p>
            </div>
          </div>

          {/* Navigation */}
          <nav className="hidden md:flex items-center gap-6">
            <Button variant="ghost" onClick={onSignIn} className="gap-2">
              <User className="w-4 h-4" />
              Sign-on
            </Button>
            <Button variant="ghost" onClick={onAboutUs}>
              About Us
            </Button>
            <Button variant="ghost" onClick={onContact} className="gap-2">
              <Phone className="w-4 h-4" />
              Contact Us
            </Button>
            <Button variant="automotive" onClick={onRegistration} className="gap-2">
              <FileText className="w-4 h-4" />
              Registration
            </Button>
          </nav>

          {/* Mobile Menu Button */}
          <Button variant="ghost" className="md:hidden">
            <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </Button>
        </div>
      </div>
    </header>
  );
};