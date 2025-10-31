package dev.datlag.kommons


data object SaoTomeAndPrincipe : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("ST")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("STP")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(678)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(239)
    override val continent: Continent = Continent.Africa
}